#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n6_notasCurso
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/notasCurso.jar:./test/lib/notasCursoTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.notasCurso.test.NotasTest
java -ea -classpath ./lib/notasCurso.jar:./test/lib/notasCursoTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.notasCurso.test.CursoTest
cd bin/mac

stty echo
