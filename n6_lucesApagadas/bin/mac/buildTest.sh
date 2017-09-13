#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n6_lucesApagadas
# Autor: Vanessa P�rez Romanello - 17-ago-2011
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Asegura la creaci�n de los directorios classes y lib en test
# ---------------------------------------------------------

cd ../../test/
mkdir classes
mkdir lib

# ---------------------------------------------------------
# Compila las clases del directotio test/source
# ---------------------------------------------------------

cd source
javac -source 1.5 -classpath ../../lib/lucesApagadas.jar:../lib/junit.jar -d ../classes/ uniandes/cupi2/lucesApagadas/test/*.java

# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------

cd ../classes

jar cf ../lib/lucesApagadasTest.jar uniandes/* -C ../data .

cd ../../bin/mac

stty echo