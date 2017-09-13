#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n3_parqueEmpresarial
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/cupiZoologico.jar:./test/lib/cupiZoologicoTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.AnimalTest
java -ea -classpath ./lib/cupiZoologico.jar:./test/lib/cupiZoologicoTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.GuardiaTest
java -ea -classpath ./lib/cupiZoologico.jar:./test/lib/cupiZoologicoTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.JaulaTest
java -ea -classpath ./lib/cupiZoologico.jar:./test/lib/cupiZoologicoTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.ZoologicoTest

cd bin/mac

stty echo
