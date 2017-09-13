#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n9_cupiTrenes
# Autor: Vanessa P�rez Romanello - 07-oct-2011
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiTrenes.jar:test/lib/junit.jar:test/lib/cupiTrenesTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTrenes.test.CupiTrenesTest
	
java -ea -classpath lib/cupiTrenes.jar:test/lib/junit.jar:test/lib/cupiTrenesTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTrenes.test.ViajeTest
	
java -ea -classpath lib/cupiTrenes.jar:test/lib/junit.jar:test/lib/cupiTrenesTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTrenes.test.VagonTest
cd bin/mac

stty echo
