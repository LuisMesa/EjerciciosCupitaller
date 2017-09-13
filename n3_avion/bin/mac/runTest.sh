#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n3_avion
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/avion.jar:./test/lib/avionTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.avion.test.AvionTest
java -ea -classpath ./lib/avion.jar:./test/lib/avionTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.avion.test.EquipajeTest
java -ea -classpath ./lib/avion.jar:./test/lib/avionTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.avion.test.PasajeroTest
cd bin/mac

stty echo
