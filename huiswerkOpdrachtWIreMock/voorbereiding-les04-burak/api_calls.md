# API Call Prototype - Booking.com 

### Code
```
curl --location 'https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels?dest_id=-2140612&search_type=CITY&arrival_date=2025-06-01&departure_date=2025-06-05&adults=1&children_age=0%2C17&room_qty=1&page_number=1&units=metric&temperature_unit=c&languagecode=en-us&currency_code=AED' \
--header 'x-rapidapi-host: booking-com15.p.rapidapi.com' \
--header 'x-rapidapi-key: 55d05e8ab3mshd4eb5ebb7ab4cc6p11bf9ajsn8d710968e62b'
```

### Response Voorbeeld

```
{
                "hotel_id": 7408370,
                "accessibilityLabel": "ibis Styles Arnhem Centre.\n3 out of 5 stars.\n8.2 Very Good 5708 reviews.\n‎650 m from downtown‬.\n Entire studio – 22 m² : 2 beds • 1 bedroom • 1 bathroom.\n2351 AED.\n+167 AED taxes and charges.",
                "property": {
                    "qualityClass": 0,
                    "reviewCount": 5708,
                    "optOutFromGalleryChanges": 0,
                    "accuratePropertyClass": 3,
                    "checkout": {
                        "fromTime": "06:00",
                        "untilTime": "12:00"
                    },
                    "position": 0,
                    "longitude": 5.90270323287962,
                    "name": "ibis Styles Arnhem Centre",
                    "checkin": {
                        "fromTime": "15:00",
                        "untilTime": "00:00"
                    },
                    "blockIds": [
                        "740837005_328973169_3_2_0"
                    ],
                    "latitude": 51.9832921108032,
                    "mainPhotoId": 344773377,
                    "countryCode": "nl",
                    "photoUrls": [
                        "https://cf.bstatic.com/xdata/images/hotel/square500/344773377.jpg?k=d46a7b343e21971d88389be427302667ff1e177b5b772d92d15de657befcebdf&o=",
                        "https://cf.bstatic.com/xdata/images/hotel/square1024/344773377.jpg?k=d46a7b343e21971d88389be427302667ff1e177b5b772d92d15de657befcebdf&o=",
                        "https://cf.bstatic.com/xdata/images/hotel/square2000/344773377.jpg?k=d46a7b343e21971d88389be427302667ff1e177b5b772d92d15de657befcebdf&o="
                    ],
                    "wishlistName": "Arnhem",
                    "rankingPosition": 0,
                    "propertyClass": 3,
                    "ufi": -2140612,
                    "id": 7408370,
                    "isFirstPage": true,
                    "currency": "EUR",
                    "reviewScoreWord": "Very Good",
                    "priceBreakdown": {
                        "taxExceptions": [],
                        "benefitBadges": [],
                        "excludedPrice": {
                            "currency": "AED",
                            "value": 167.334610654195
                        },
                        "grossPrice": {
                            "value": 2350.81223024764,
                            "currency": "AED"
                        }
                    },
                    "isPreferred": true,
                    "reviewScore": 8.2,
                    "checkoutDate": "2025-06-05",
                    "checkinDate": "2025-06-01"
                }
            },
```
