# Sistema de Gestión de Torneo de Videojuegos

## Descripción
Proyecto académico que implementa un sistema de gestión para torneos de videojuegos. Permite administrar jugadores, torneos y simulaciones/partidas.

## Estructura del Proyecto

```
src/
└── models/
    ├── Administracion.java        (Clase principal - main)
    ├── Jugador.java
    ├── Torneo.java
    └── Simulacion.java
```

**Clases:**
- `Administracion.java` - Punto de entrada del programa (Clase principal)
- `Jugador.java` - Representa a un participante del torneo
- `Torneo.java` - Contenedor principal que organiza el evento
- `Simulacion.java` - Representa cada partida/simulación del torneo

## Diagrama de Clases
Ver archivo: `DiagramaUMLClases.wsd` (aca tenemos que poner la imagen del diagrama UML)

**Relaciones:**
- Administracion **crea** → Torneo, Jugador, Simulacion
- Torneo **1** ← **0..*** Simulacion (involucra)
- Simulacion **0..*** ↔ **0..*** Jugador (contiene/participa)

## Cómo Compilar y Ejecutar

**Compilar:**
```bash
javac -d build/ src/Administracion.java src/models/*.java
```

**Ejecutar:**
```bash
java -cp build/ Administracion
```

## Requisitos
- Java 11 o superior

## Integrantes del Equipo
- Maxi Moncada (maxilucianomoncada@gmail.com)
- Matias Moyano (email)
- Maximo Zalazar (mail)

## Notas
- Todas las clases se encuentran en una carpeta `src/` con una subcarpeta `models/`
- El programa compilado se genera en la carpeta `build/` 

