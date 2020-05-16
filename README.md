# vehicle-manager-service

1- A api realiza as seguintes ações:
- Cadastro de Veiculos;
- Atualização dos dados de um veiculo;
- Exclusão de um veiculo;
- Exibi informações de quantos veiculos não foram vendidos;
- Exibi informação da distribuição de veículos por fabricante.

2 - Executando o projeto:

2.1 - Baixar o projeto através do comando:

https://github.com/jsilvaferreira/vehicle-manager-service.git

2.2 - Realizar o comando 'mvn clean install' para buildar o projeto. Se necessário, rodar o comando anterior como 'mvn clean install  -U' caso tenha problemas com dependência do maven.

2.3 - Configurar o banco de dados rodando o comando a seguir:

Obs.: Lembrando que para rodar o comando abaixo é necessário ter o docker instalado em sua máquina:

'sudo docker run -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=tinnova -e MYSQL_USER=VehicleManager -e MYSQL_PASSWORD=vms -p 3306:3306 -d mysql:latest'

2.4 - Para entrar no banco de dados configurado no projeto, executas os seguintes comandos seguindo a ordem:
 
 ```
 docker exec -it mysql:latest bash
 
 mysql -u VehicleManager -p
 
 use tinnova
 ```

3 - EndPoints:

-'GET - /api/veiculos'

-'GET - /api/veiculos/{vehicleId}'

-'GET - /api/veiculos/totalVendidos'

-'GET - /api/veiculos/distribuicaoPorFabricante'

-'POST - /api/veiculos'

-'PUT - /api/veiculos'

-'DELETE - /api/veiculos/{vehicleId}'

4 - Dentro da pasta '../resources/postman' contém um arquivo para chamar cada EndPoint do projeto. Esse arquivo precisa ser inserido//importado no Programa Postman. [Clique aqui para baixar](https://www.postman.com/downloads/)

:+1::+1:

