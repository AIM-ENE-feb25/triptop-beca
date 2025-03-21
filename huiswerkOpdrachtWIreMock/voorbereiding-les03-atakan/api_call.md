# API Call voor WireMock

Getest met Insomnia en gewijzigd naar CURL:

```
curl --request POST \
  --url https://triptop-identity.wiremockapi.cloud/login \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
	"username": "edevries",
	"password": "3g2Rw9sT1x"
}'
```

```
curl --request POST \
  --url https://triptop-identity.wiremockapi.cloud/checkAppAccess \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
	"username": "edevries",
	"application": "triptop"
}'
```
