# Sistema de Eventos
# Repositório para API do sistema de eventos

O Projeto consiste em uma plataforma de eventos, onde os usuários poderão visualizar quais eventos estão ocorrendo em sua região,
além de ser inscrever para eventos futuros, a gerencia dos eventos se dará pelos administradores, que farão o cadadastro, exclusão e alteração dos eventos, com seu nome, data, horário de inicio e fim, localização e palestrantes. Os usuários serão notificados quando os eventos estiverem
prestes a começar, poderão avaliar-los e compartilha-los através de suas redes sociais.


Atores:
	Usuário
	Administrador
  
Funcionalidades:
	Backoffice
		Cadastro/Exclusão/Alteração e Listagem de usuários
		Cadastro/Exclusão/Alteração e Listagem de palestrantes
		Cadastro/Exclusão/Alteração e Listagem de eventos
	App
		Visualização de eventos próximos ao usuário
		Inscrição em eventos
		Avaliação de eventos
		Visualização de eventos inscritos
		Notificação de eventos próximos
		Compartilhamento de evento em redes sociais
		Autenticação e cadastro via rede social(Facebook, Google)

# Requisitos de desenvolvimento
	Infra
		Docker
			Containers para Banco de dados, Web API, e Aplicação web separados
		Amazon
			Máquina para envio de containers
		Deploy 
			Deploy automatizado(Opcional)
		Backup
			Rotina de backup para banco de dados

	Banco de dados
		Postgres
	WebAPI
		SpringBoot
		SpringData JPA
		Spring Security
		Paginação
		Swagger

	Portal
		Angular
			RXJS
			NPM
			Bootstrap 4
	App Android
		Kotlin
		MVVM
		RXJava
		Retrofit
		AutoLayout
		Material Design
		Testes Unitários e Integrados
	App IOS
		Swift
		MVVM
		RXSwift
		Alamofire
		AutoLayout
		FlatDesign
		Testes Unitários e Integrados
		Fastlane(Opcional)
