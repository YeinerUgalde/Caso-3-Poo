# Caso-3-Poo
Caso 3 de poo

Caso 3 de poo: Garden

Para añadir un nuevo tipo de planta:

![image](https://user-images.githubusercontent.com/103976664/194978755-b4472cfb-b6d0-4a1f-9b1a-45216b810734.png)

Luego de añadir la coma pegar:


 {
      "nombre" : "PlantaX",
      "id": "0",
      "Vitalidad" : "100",
      "Fruto" : "Fruto x",
      "Edad_maxima_en_dias" : "500",
      "States" : [
      {
        "EstadoID" : "0",
        "EstadoName" : "muerta",
        "RangeTime" : "0",
        "Imagen" : "../Caso 3/src/Imagenes/nombredelaimagen.jpg"
      }, 
      {
        "EstadoID" : "1",
        "EstadoName" : "pequeña/albacigo",
        "RangeTime" : "60",
        "Imagen" : "../Caso 3/src/Imagenes/nombredelaimagen.jpg",
        "rules" : {
        	"MinNivelSol" : "50",
  			"MaxNivelSol" : "70",
       		"MinNivelAgua" : "30",
       		"MaxNivelAgua" : "50",
       		"MinNivelAbono" : "40",
       		"MaxNivelAbono" : "60"
        },
        "effects":{
        	"bajarAguaEffect":"5",
        	"bajarAbonoEffect":"3",
        	"bajarVidaEffect":"1",
        	"SubirVidaEffect" : "1",
        	"AumentarAbono":"5",
        	"AumentarAgua":"5"
        }
      },
      {
        "EstadoID" : "2",
        "EstadoName" : "joven/meidana",
        
        "RangeTime" : "2",
        "Imagen" : "../Caso 3/src/Imagenes/nombredelaimagen.jpg",
        "rules" : {
        	"MinNivelSol" : "50",
        	"MaxNivelSol" : "70",
       		"MinNivelAgua" : "40",
        	"MaxNivelAgua" : "60",
        	"MinNivelAbono" : "40",
        	"MaxNivelAbono" : "60"
         },
         "effects":{
        	"bajarAguaEffect":"5",
        	"bajarAbonoEffect":"3",
        	"bajarVidaEffect":"1",
        	"SubirVidaEffect" : "1",
        	"AumentarAbono":"5",
        	"AumentarAgua":"5"
        }
       },
       {
         "EstadoID" : "3",
         "EstadoName" : "adulta/grande",         
         "RangeTime" : "60",
         "Imagen" : "../Caso 3/src/Imagenes/nombredelaimagen.jpg",
         "rules" : {
        	"MinNivelSol" : "65",
         	"MaxNivelSol" : "80",
         	"MinNivelAgua" : "60",
         	"MaxNivelAgua" : "80",
         	"MinNivelAbono" : "40",
         	"MaxNivelAbono" : "60"
          },
          "effects":{
        	"bajarAguaEffect":"5",
        	"bajarAbonoEffect":"3",
        	"bajarVidaEffect":"1",
        	"SubirVidaEffect" : "1",
        	"AumentarAbono":"5",
        	"AumentarAgua":"5"
          }
        }
        ]
  }

