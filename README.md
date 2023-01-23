# API-Tweetero

## Criação de usuário.
```yml
POST /sign-up
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
