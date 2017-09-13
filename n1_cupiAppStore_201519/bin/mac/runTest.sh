#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n1_cupiAppStore
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/cupiAppStore.jar:./test/lib/cupiAppStoreTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiAppStore.test.AppStoreTest
java -ea -classpath ./lib/cupiAppStore.jar:./test/lib/cupiAppStoreTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiAppStore.test.JuegoTest
cd bin/mac

stty echo
