## Overview
ToneForge is a public API that converts text into specific lingos. For example, using the "Pirate" lingo, it might convert:

Hello, Friend → Ahoy Matey!

It is built with **Spring Boot**, hosted on **AWS**, and uses the **Gemini API** for language conversion.

## Usage

Send a **POST** request to the API:

`POST https://toneforge/api/convert`

Content-Type: application/json

```json
{
    "strategy": "Pirate",
    "text": "Hello, Friend"
}
```

The response will be JSON:
```json
{
    "original": "Hello, Friend",
    "converted": "Ahoy Matey!",
    "lingo": "Pirate",
    "error": null
}
```

Below is a simple JavaScript example.

```js
const response = await fetch(`${API_BASE}/convert`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ strategy, text })
});
```

## Endpoints

| Endpoint              | Method | Description                              |
|-----------------------|--------|------------------------------------------|
| `/api/convert`        | POST   | Convert text to the specified lingo      |
| `/api/strategies`     | GET    | Returns a list of all available lingos/strategies     |
