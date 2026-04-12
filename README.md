# Sistema de Gestión de Torneo de Videojuegos

## Descripción
Proyecto académico que implementa un sistema de gestión para torneos de videojuegos en formato 2vs2. Permite administrar jugadores, simular partidas y visualizar rankings.

## Características
- Máximo 10 jugadores por torneo
- Partidas en formato 2vs2 (4 jugadores por partida)
- Simulación automática de resultados
- Ranking de jugadores por puntaje
- Historial de partidas

## Estructura del Proyecto

```
src/models/
├── Administracion.java    Punto de entrada del programa
├── Jugador.java          Representa un participante
├── Torneo.java           Gestiona el torneo y partidas
└── Partida.java          Representa cada enfrentamiento 2vs2
```

## Clases

- **Administracion**: Menú principal y control de flujo
- **Torneo**: Contiene jugadores y partidas, máximo 10 jugadores
- **Jugador**: Almacena datos del participante (DNI, nombre, nacionalidad, estadísticas)
- **Partida**: Representa enfrentamiento 2vs2 con 4 jugadores

## Diagrama UML

- Diagrama de Clases: `DiagramaUMLClases.wsd`
- Diagrama de Objetos: `DiagramaUMLObjetos.wsd`

## Cómo Compilar y Ejecutar

Compilar:
```bash
javac -d bin/ src/models/*.java
```

Ejecutar:
```bash
java -cp bin/ src.models.Administracion
```

## Requisitos
- Java 11 o superior

## Integrantes del Equipo
- Maxi Moncada (maxilucianomoncada@gmail.com)
- Matias Moyano (matiasmoyanobustos@gmail.com)
- Maximo Zalazar (mail)
 

