#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n3_cupiTablaPeriodica
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/cupiTablaPeriodica.jar:./test/lib/cupiTablaPeriodicaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiTablaPeriodica.test.ElementoTest
java -ea -classpath ./lib/cupiTablaPeriodica.jar:./test/lib/cupiTablaPeriodicaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiTablaPeriodica.test.TablaPeriodicaTest

cd bin/mac

stty echo
