# vehicle-manager-service

1- Realiza:
- Cadastro de Veiculos;
- Atualização dos dados de um veiculo;
- Exclusão de um veiculo;
- Exibi informações de quantos veiculos não foram vendidos;
- Exibi informação da distribuição de veículos por fabricante.

2 - EndPoints:
-- GET - /api/veiculos
  Response:
  {
        "id": 1,
        "vehicle": "Focus",
        "brand": "Ford",
        "year": 2011,
        "description": "Carro intermediário",
        "sold": true,
        "created": "2020-01-04T21:00:00-03:00",
        "update": "2020-05-15T21:00:00-03:00"
    },
    {
        "id": 2,
        "vehicle": "Civic",
        "brand": "Honda",
        "year": 2009,
        "description": "Carro de luxo",
        "sold": false,
        "created": "2019-12-31T21:00:00-03:00",
        "update": "2020-04-30T21:00:00-03:00"
    }
    
-- GET - /api/veiculos/{vehicleId}
  Response:
  {
    "id": 2,
    "vehicle": "Civic",
    "brand": "Honda",
    "year": 2009,
    "description": "Carro de luxo",
    "sold": true,
    "created": "2019-12-31T21:00:00-03:00",
    "update": "2020-04-30T21:00:00-03:00"
}

-- GET - /api/veiculos/totalVendidos
  Response:
  {
    "total": 2
  }
  
-- GET - /api/veiculos/distribuicaoPorFabricante
  Response:
  {
        "brand": "Ford",
        "total": 4
    },
    {
        "brand": "Honda",
        "total": 2
    },
    {
        "brand": "Volkswagem",
        "total": 1
    },
    {
        "brand": "Chevrolet",
        "total": 2
    }

-- POST - /api/veiculos
  Response:
  {
    "id": 9,
    "vehicle": "Fit",
    "brand": "Honda",
    "year": 2020,
    "description": "Carro de luxo",
    "sold": true
  }

-- DELETE - /api/veiculos/{vehicleId}
  Response: N/A
  
-- PUT - /api/veiculos
  Response:
  {
    "id": 4,
    "vehicle": "Gol",
    "brand": "Volkswagem",
    "year": 2010,
    "description": "Carro de entrada",
    "sold": true
 }
 
 3 - Execução do banco de dados
 
 3.1 - Executar o seguinte comando para criação da imagem do docker do mysql com as configurações do projeto:
 
 sudo docker run -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=tinnova -e MYSQL_USER=VehicleManager -e MYSQL_PASSWORD=vms -p 3306:3306 -d mysql:latest
 
 3.2 - Entrar no modo iterativo:
 docker exec -it mysql:latest bash
 
 3.3 - Executar os seguintes comandos para entrar no database tinnova:
 
 mysql -u VehicleManager -p 
 use tinnova
 
