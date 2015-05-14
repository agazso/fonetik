#!/bin/sh -ex

distdir=dist/fonetik

mvn package

rm -rf dist
mkdir -p $distdir
cp target/fonetik-*.jar $distdir
cp -r target/libs $distdir
cp scripts/* $distdir
cp -r asset $distdir

cd dist
zip -r fonetik.zip fonetik
cd -