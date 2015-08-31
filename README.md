# Sample Drools Service


curl "http://127.0.0.1:8080/calculate" -X POST -H "Content-Type: application/json" -w \\n -d '{ "subtotal": 1000, "zipCode": 4375000, "customerProfile": "PREMIUM" }'

curl "http://127.0.0.1:8080/calculate" -X POST -H "Content-Type: application/json" -w \\n -d '{ "subtotal": 99, "zipCode": 12345678, "customerProfile": "FIRST_TIME_BUYER" }'

curl "http://127.0.0.1:8080/calculate" -X POST -H "Content-Type: application/json" -w \\n -d '{ "subtotal": 99, "zipCode": 12345678 }'

curl "http://127.0.0.1:8080/calculate" -X POST -H "Content-Type: application/json" -w \\n -d '{ "subtotal": 1000, "zipCode": 12345678, "products": [ { "skuCode": "000-000-0000", "categoryCode": "CAT_TESTE" } ] }'
