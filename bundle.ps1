
if (Test-Path "app.jar") {
    rm app.jar
}
echo "building uberjar"
lein uberjar
echo "Copying uberjar to ./app.jar"
$f = Get-ChildItem target -Name -Include *.jar -Filter *alone*
cp target/$f app.jar
