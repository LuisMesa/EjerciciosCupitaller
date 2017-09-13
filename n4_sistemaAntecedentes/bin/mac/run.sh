#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n4_sistemaAntecedentes
# Autor: Rafael Mu�oz Lattion - 24-ene-2012
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n del programa
# ---------------------------------------------------------

cd ../..
java -ea -classpath ./lib/sistemaAntecedentes.jar uniandes.cupi2.sistemaAntecedentes.interfaz.InterfazSistemaAntecedentes
cd bin/mac

stty echo
