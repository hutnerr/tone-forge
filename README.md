## Overview
ToneForge is a public API that converts text into specific lingos. For example, using the "Pirate" lingo, it might convert:

Hello, Friend → Ahoy Matey!

It is built with **Spring Boot**, hosted on **AWS**, and uses the **Gemini API** for language conversion.

You can view a simple demo of the API [here](https://hutnerr.github.io/tone-forge/). 

> Limit's are strict due to me being on the free plan of Gemini as well as AWS.

## Usage

Send a request to the API:

> `POST http://44.197.230.236/api/convert`

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
const response = await fetch(`http://44.197.230.236/api/convert`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ strategy, text })
});
```

## Endpoints

> `http://44.197.230.236/api/...`

| Endpoint              | Method | Description                              |
|-----------------------|--------|------------------------------------------|
| `/convert`        | POST   | Convert text to the specified lingo      |
| `/strategies`     | GET    | Returns a list of all available lingos/strategies     |
