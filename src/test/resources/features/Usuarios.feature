# language: pt
# encoding: UTF-8

Funcionalidade: Gerenciar usuários via API

  Como administrador do sistema
  eu quero gerenciar os usários da aplicação
  para incluir e manter os dados e privilégios da minha equipe

  Contexto: Usuário com permissão para gerenciar usuários
    Dado que o usuário do sistema tenha gerado o token de acesso da API

  @automatizado
  Cenário: Recuperar minhas informações
    Quando solicitar recuperar suas informações via API
    Então o sistema deve retornar os dados do usuário que realizou a requisição
      | id           |
      | name         |
      | email        |
      | language     |
      | timezone     |
      | access_level |
      | projects     |

  Cenário: Criar um usuário com dados completos
    E informou os dados completos do novo usuário
    Quando solicitar a inclusão de novo usuário via API
    Então o sistema deve sinalizar a inclusão com sucesso
    E deve retornar os dados do usuário
      | name         |
      | real_name    |
      | email        |
      | language     |
      | timezone     |
      | access_level |
      | projects     |

  @automatizado
  Cenário: Criar um usuário com dados mínimos
    E informou os dados minimos do novo usuário
    Quando solicitar a inclusão de novo usuário via API
    Então o sistema deve sinalizar a inclusão com sucesso
    E deve retornar os dados do usuário
      | name         |
      | real_name    |
      | email        |
      | language     |
      | timezone     |
      | access_level |
      | projects     |

  Cenário: Deletar um usuário
    E informou o identificador do usuário
    Quando solicitar a exclusão do usuário via API
    Então o sistema deve sinalizar a exclusão com sucesso
