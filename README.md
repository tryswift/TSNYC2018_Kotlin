
## assumptions
1. you are using a mac
2. you have used or know some swift

## Android Studio
1. download here: https://developer.android.com/studio/
2. run the installer
3. don't import settings
4. select next
5. choose custom, and select next
6. choose your favorite color scheme
7. For `SDK components setup`
  a. select all check boxes that you can
  b. select HAXM as well if possible (you may already have haxm installed and can't install again)
  c. select next
8. click on Finish


##download latest sdk
during install you should see a dialog asking which sdk you want to install, choose API 28
if you don't see this dialog, once the app has installed, 
  1. open Android Studio and go to `Tools > SDK Manager`
  2. select API 28 and click OK
  3. the API should start downloading
  4. once the API has finished downloading click ok


##create virtual device
during install you should see a dialog asking if you want to create a virtual device
if you don't see this dialog, 
  1. go to `Tools > AVD Manager`
  2. select virtual device
  3. Under Phone, select Pixel 2, click next
  4. Choose API 28, click next
  5. Just use the default values, and click on Finish


## install JSON Place Holder 
can install locally or, if internet is available, use https://jsonplaceholder.typicode.com/

1. install node (https://nodejs.org/en/download/)

2. make sure /usr/local/bin is in path
```
echo $PATH
```

3. verify node is installed
```
npm -v
node -v
```

4. install json-server
```sudo npm install -g json-server```

5. setup json-placeholder
  a. download:  https://github.com/Herbal7ea/jsonplaceholder

6. install json server localally to the jsonplaceholder folder
  a. in terminal navigate to the `jsonplaceholder` folder
  b. run the following:
```
npm init -y
npm install json-server --save-dev
node index.js
navigate: http://localhost:3000/posts/1
```

## if there are problems you can default to using https://jsonplaceholder.typicode.com/ in your network layer
