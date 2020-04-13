# language: pt
# encoding: UTF-8

Funcionalidade: Gerenciar usuários via API

  Como administrador do sistema
  eu quero gerenciar os usários da aplicação
  para incluir e manter os dados e privilégios da minha equipe

  Contexto: Usuário com permissão para gerenciar usuários
    Dado que o usuário do sistema tenha gerado o token de acesso da API

  @teste
  Cenário: Recuperar minhas informações
    Quando solicitar recuperar suas informações via API
    Então o sistema deve retornar os dados do usuário que realizou a requisição
      | Dados do Usuário |
      | id               |
      | name             |
      | email            |
      | language         |
      | timezone         |
      | access_level     |
      | projects         |

  Cenário: Criar um usuário com dados completos
    Quando informar os dados completos do novo usuário
    E solicitar a inclusão de novo usuário via API
    Então o sistema deve sinalizar a inclusão com sucesso
    E deve retornar os dados do usuário
      | Dados do Usuário |
      | name             |
      | real_name        |
      | email            |
      | language         |
      | timezone         |
      | access_level     |
      | projects         |

  Cenário: Criar um usuário com dados mínimos
    Quando informar os dados minimos do novo usuário
    E solicitar a inclusão de novo usuário via API
    Então o sistema deve sinalizar a inclusão com sucesso
    E deve retornar os dados do usuário
      | Dados do Usuário |
      | name             |
      | real_name        |
      | email            |
      | language         |
      | timezone         |
      | access_level     |
      | projects         |

  Cenário: Deletar um usuário
    Quando informar o identificador do usuário
    E solicitar a exclusão do usuário via API
    Então o sistema deve sinalizar a exclusão com sucesso
