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
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/lucesApagadas.jar:test/lib/junit.jar:test/lib/lucesApagadasTest.jar junit.swingui.TestRunner uniandes.cupi2.lucesApagadas.test.VentanaTest
	
java -ea -classpath lib/lucesApagadas.jar:test/lib/junit.jar:test/lib/lucesApagadasTest.jar junit.swingui.TestRunner uniandes.cupi2.lucesApagadas.test.CastilloTest
cd bin/mac

stty echo
