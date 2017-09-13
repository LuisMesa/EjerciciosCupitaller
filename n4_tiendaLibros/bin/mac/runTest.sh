#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n4_tiendaLibros
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/tiendaLibros.jar:./test/lib/tiendaLibrosTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.LibroTest
java -ea -classpath ./lib/tiendaLibros.jar:./test/lib/tiendaLibrosTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.ItemCompraTest
java -ea -classpath ./lib/tiendaLibros.jar:./test/lib/tiendaLibrosTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.CarroComprasTest
java -ea -classpath ./lib/tiendaLibros.jar:./test/lib/tiendaLibrosTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.TiendaLibrosTest
cd bin/mac

stty echo
