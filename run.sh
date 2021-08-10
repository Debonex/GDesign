./stop.sh
# conda env
source D:/anaconda/etc/profile.d/conda.sh
conda activate tensor
nohup consul agent -dev > ./logs/consul.log &
nohup java -jar ./gdesign-consumer/target/consumer-service.jar > ./logs/consumer-service.log &
nohup java -jar ./gdesign-business/target/business-service.jar > ./logs/business-service.log &
cd ./gdesign-rec 
nohup python ./application.py dev > ../logs/rec-service.log &
cd ../gdesign-front/nginx
nginx -c ./nginx.conf