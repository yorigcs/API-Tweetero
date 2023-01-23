# API-Tweetero

- Use o front-end-tweetero presente na raiz do projeto para ter compatibilidade com o back-end.

<div style=display: flex;">
<img style="width:40%; height:40%;"  src= "https://bootcampra.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fc23c3a17-17a4-459e-853e-a125695f4858%2FUntitled.png?id=7f665d83-06a1-47f9-90dd-1f574adcb5b0&table=block&spaceId=f797e032-5eb2-4c9d-beb7-cd7181e19e47&width=580&userId=&cache=v2">

<img style="width:40%; height:40%;" src= "https://bootcampra.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fe813c786-a52a-4461-ab1d-e69781cb0546%2FUntitled.png?id=2f37a34d-0b1b-4630-8de2-687667cbb467&table=block&spaceId=f797e032-5eb2-4c9d-beb7-cd7181e19e47&width=580&userId=&cache=v2">

</div>

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
