# API-Tweetero

BASE_URL = http://localhost:8080/api
## Criação de usuário.
```yml
POST BASE_URL/auth/sign-up
    - headers: {}
    - body: {
      username: "Yorí",
      avatar: "https://i.imgur.com/zYnwrrg.png" 
    }
    
RESPOSTA CASO SUCESSO
    - status: 201
    - body:"Ok"

RESPOSTA CASOS DE ERRO
  - CORPO DO PEDIDO MAL FORMATADO
    - status: 400
    - body: { error: "Field[X] error message"}
   
  - USERNAME JÁ EXISTENTE
    - status: 409
    - body: { error: "This username already exists!" }
```

## Criação de tweet.
```yml
POST BASE_URL/tweets
    - headers: {}
    - body: {
      username: "Yorí",
      tweet: "Um tweet qualquer" 
    }
    
RESPOSTA CASO SUCESSO
    - status: 201
    - body:"Ok"

RESPOSTA CASOS DE ERRO
  - CORPO DO PEDIDO MAL FORMATADO
    - status: 400
    - body: { error: "Field[X] error message"}
   
  - USERNAME NÃO EXISTENTE
    - status: 404
    - body: { error: "There is not an user with this username" }
```

## Lista todos tweets do username específico.
```yml
GET BASE_URL/tweets/Yorí
    - headers: {}
RESPOSTA CASO SUCESSO
    - status: 200
    - body: [
      {
        username: "Yorí",
        avatar: "https://i.imgur.com/zYnwrrg.png",
        tweet: "Um tweet qualquer"
      }, ...
    ]

RESPOSTA CASOS DE ERRO
  - USERNAME NÃO EXISTENTE
    - status: 404
    - body: { error: "There is not an user with this username" }
```

## Lista 5 tweets por pagina.
```yml
GET BASE_URL/tweets?page=0
    - headers: {}
RESPOSTA CASO SUCESSO
    - status: 200
    - body: [
      {
        username: "Yorí",
        avatar: "https://i.imgur.com/zYnwrrg.png",
        tweet: "Um tweet qualquer"
      },
      {
        username: "test",
        avatar: "https://i.imgur.com/zYnwrrg.png",
        tweet: "outro tweet qualquer"
      }, ....
    ]
```