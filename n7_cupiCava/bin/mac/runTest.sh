#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n7_cupiCava
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/cupiCava.jar:./test/lib/cupiCavaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiCava.test.VinoTest
java -ea -classpath ./lib/cupiCava.jar:./test/lib/cupiCavaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiCava.test.CavaTest

cd bin/mac

stty echo
