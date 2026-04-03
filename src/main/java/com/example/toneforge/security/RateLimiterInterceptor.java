package com.example.toneforge.security;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimiterInterceptor implements HandlerInterceptor 
{
    private final Map<String, RequestInfo> requestCounts = new ConcurrentHashMap<>();
    private final int MAX_REQUESTS = 5;      // max requests per time window
    private final long TIME_WINDOW = 60_000;  // 1 minute in milliseconds

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
    {
        String method = request.getMethod();
        if (!method.equals("GET") && !method.equals("POST")) return true; // allow other methods without limit

        String ip = request.getRemoteAddr();
        long now = Instant.now().toEpochMilli();

        RequestInfo info = requestCounts.getOrDefault(ip, new RequestInfo(0, now));

        if (now - info.timestamp > TIME_WINDOW) info = new RequestInfo(0, now);
        if (info.count >= MAX_REQUESTS) {
            response.setStatus(429); // too many reqs
            return false;
        }

        // increment by creating a new record
        info = new RequestInfo(info.count + 1, info.timestamp);
        requestCounts.put(ip, info);

        return true; // allow request
    }

    // immutable record for request count + timestamp
    private record RequestInfo(int count, long timestamp) {}
}