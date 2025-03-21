# API Call Prototype - Google Maps API & Map Data

## Google Maps API

```
curl --request POST \
  --url https://google-api31.p.rapidapi.com/map \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --header 'x-rapidapi-host: google-api31.p.rapidapi.com' \
  --header 'x-rapidapi-key: a192e8d333msh1f0f45be4b92f5bp163a1cjsnb2df68a80a60' \
  --data '{
  "text": "Anne Frank House",
  "place": "",
  "street": "",
  "city": "",
  "country": "Netherlands",
  "state": "",
  "postalcode": "",
  "latitude": "",
  "longitude": "",
  "radius": ""
}'
```

### Response Voorbeeld

```
{
	"result": [
		{
			"title": "Anne Frank House",
			"address": "Prinsengracht 263 - 267, Museum Entrance Westermarkt 20, Amsterdam, NL ",
			"country_code": null,
			"url": "https://www.annefrank.org",
			"phone": "+31205567105",
			"latitude": 52.3750653,
			"longitude": 4.8840145,
			"source": "https://www.tripadvisor.com/Attraction_Review-g188590-d190555-Reviews-Anne_Frank_House-Amsterdam_North_Holland_Province.html?m=63959",
			"image": "",
			"desc": "",
			"hours": "",
			"category": "Specialty museum",
			"facebook": "",
			"instagram": "",
			"twitter": "",
			"google_maps": "https://maps.google.com/?q=52.3750653,4.8840145"
		}
	]
}
```

## Maps Data API

```
curl --request GET \
  --url 'https://maps-data.p.rapidapi.com/searchmaps.php?query=Gastronoom%20Presikhaaf&limit=20&country=nl&lang=nl&offset=0&zoom=13' \
  --header 'User-Agent: insomnia/10.3.1' \
  --header 'x-rapidapi-host: maps-data.p.rapidapi.com' \
  --header 'x-rapidapi-key: a192e8d333msh1f0f45be4b92f5bp163a1cjsnb2df68a80a60'
```

### Response Voorbeeld

```
{
	"status": "ok",
	"data": [
		{
			"business_id": "0x47c7a46c873bfbe7:0x83f42616de58a6e3",
			"phone_number": "0263614500",
			"name": "De Gastronoom Volkerakstraat.",
			"full_address": "De Gastronoom Volkerakstraat., Volkerakstraat 6, 6826 EM Arnhem",
			"full_address_array": [
				"Volkerakstraat 6",
				"6826 EM Arnhem"
			],
			"latitude": 51.980215799999996,
			"longitude": 5.9454267,
			"review_count": 303,
			"rating": 4.3,
			"timezone": "Europe\/Amsterdam",
			"website": "http:\/\/www.degastronoom.com\/",
			"place_id": "ChIJ5_s7h2ykx0cR46ZY3hYm9IM",
			"place_link": "https:\/\/www.google.com\/maps\/place\/data=!3m1!4b1!4m2!3m1!1s0x47c7a46c873bfbe7:0x83f42616de58a6e3",
			"types": [
				"Cafetaria",
				"Snackbar"
			],
			"price_level": null,
			"working_hours": {
				"vrijdag": [
					"11:30–22:00"
				],
				"zaterdag": [
					"11:30–22:00"
				],
				"zondag": [
					"12:00–22:00"
				],
				"maandag": [
					"11:30–22:00"
				],
				"dinsdag": [
					"11:30–22:00"
				],
				"woensdag": [
					"11:30–22:00"
				],
				"donderdag": [
					"11:30–22:00"
				]
			},
			"city": "Arnhem",
			"is_claimed": true,
			"verified": true,
			"photos": [
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipM0Qf3ckAAJ_emihiioqY-gX2nfN22ECXn7hULa=w203-h203-k-no",
					"max_size": [
						3264,
						3264
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipMs90WHG8SV8YBHVTiiNdnUGn3i4co1HyTqSnnW=w203-h203-k-no",
					"max_size": [
						2048,
						2048
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipOimjs3TmTiQBS2WzrO4VOTbqOViEs1Ca44D94v=w203-h270-k-no",
					"max_size": [
						3024,
						4032
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipMX9KvNAofxwuxqoZwb5q94jdT516_nPA7CoWHB=w203-h114-k-no",
					"max_size": [
						1920,
						1080
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipM2pVKqkbxOdj3o2vtoCk0cF3bTy69m7uCBZKZD=w203-h270-k-no",
					"max_size": [
						1200,
						1600
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipO6v8M2DKwdy36lnVhS__7uVAe298UtCaD3kxVn=w203-h152-k-no",
					"max_size": [
						3264,
						2448
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipNP48S1X0wQsHfcRpwi04fCtKZSjR1Di4BM73Av=w203-h113-k-no",
					"max_size": [
						1280,
						716
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipOsPC6RULSXHWQD0-dZXQbaKx73Q_4AV9ZK85qU=w203-h270-k-no",
					"max_size": [
						3024,
						4032
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/lh5.googleusercontent.com\/p\/AF1QipNTAoRkKWADGHGvwW0uQ3xY3dkGZEoYAuqx0tCR=w203-h152-k-no",
					"max_size": [
						1280,
						960
					],
					"min_size": [
						203,
						100
					]
				},
				{
					"src": "https:\/\/streetviewpixels-pa.googleapis.com\/v1\/thumbnail?panoid=ENFMyAjMhrmqBkP_1VHWYQ&cb_client=search.gws-prod.gps&w=203&h=100&yaw=122.56551&pitch=0&thumbfov=100",
					"max_size": null,
					"min_size": [
						203,
						100
					]
				}
			],
			"state": "Gesloten ⋅ Gaat open om 11:30",
			"description": []
		}
	]
}
```
