./stop.sh
cd ./Gdesign-consumer
mvn clean -U package
cd ../Gdesign-business
mvn clean -U package
cd ../gdesign-front
npm run build
cd ..
