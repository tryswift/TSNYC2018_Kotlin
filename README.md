
## assumptions
you are using a mac
you have used or know some swift

## Android Studio
download here: https://developer.android.com/studio/
run the installer
don't import settings
select next
choose custom, and select next
choose your favorite color scheme
For `SDK components setup`
	select all check boxes that you can
	select HAXM as well if possible (you may already have haxm installed and can't install again)
	select next
click on Finish


##download latest sdk
during install you should see a dialog asking which sdk you want to install, choose API 28
if you don't see this dialog, once the app has installed, open Android Studio and go to `Tools > SDK Manager`
select API 28 and click OK
the API should start downloading
once the API has finished downloading click ok


##create virtual device
during install you should see a dialog asking if you want to create a virtual device
if you don't see this dialog, go to `Tools > AVD Manager`
select virtual device
Under Phone, select Pixel 2, click next
Choose API 28, click next
Just use the default values, and click on Finish


## install JSON Place Holder 
	can install locally or, if internet is available, use https://jsonplaceholder.typicode.com/

##install node
https://nodejs.org/en/download/

## make sure /usr/local/bin is in path
echo $PATH   

## verify node is installed
npm -v
node -v

## install json-server
sudo npm install -g json-server

## setup json-placeholder
download:  https://github.com/Herbal7ea/jsonplaceholder

## install json server locallaly to the jsonplaceholder folder
## in terminal navigate to the `jsonplaceholder` folder
## run the following
npm init -y
npm install json-server --save-dev
node index.js
navigate: http://localhost:3000/posts/1

## if there are problems you can default to using https://jsonplaceholder.typicode.com/ in your network layer
