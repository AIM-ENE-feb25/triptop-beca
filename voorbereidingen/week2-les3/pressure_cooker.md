# Pressure cooker

## Componenten en hun verantwoordelijkheden

### API Gateway
Verantwoordelijkheid:
- Verzorgt de communicatie met externe APIs.
- Verstuurt en ontvangt gegevens via HTTPS in JSON-formaat.

### Validation Service
Verantwoordelijkheid:
- Controleert de integriteit van de ontvangen en verzonden data.
- Voorkomt het doorsturen van onjuiste of onveilige gegevens.

### Logging Service
Verantwoordelijkheid:
- Logt API-verzoeken en -responses voor traceerbaarheid.
- Ondersteunt debugging door het bijhouden van API-activiteiten.

### Externe API
Verantwoordelijkheid:
- Levert gegevens zoals boekingen, routes, vluchten etc.

## Interface beschrijving

### API CLient
```java
public interface IApiClient {
    ApiResponse sendRequest(ApiRequest request);
}
```

Parameters:
- ApiRequest request – Bevat de endpoint-URL, HTTP-methode.

Return:
- ApiResponse – Bevat de ontvangen data en eventuele foutmeldingen.

## Dynamic diagram

## Class diagram