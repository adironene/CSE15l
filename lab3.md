# Lab Report 3

[Home](https://adironene.github.io/CSE15l/index.html) 

In this lab report, I will discuss a few skills introduced to facilitate working with SSH and Github Repos. 
- **SSH Configuration** - Set up a shortcut to refrain from typing out the entire server name. If set up correctly, I only need to type `ssh ieng6` instead of `ssh cs15lsp22[user name]@ieng6.ucsd.edu`.
- **Github Access**
- **Copying Directories**

<br/><br/>

## SSH Configuration

It is tedious to type out `ssh cs15lsp22[user name]@ieng6.ucsd.edu` each time I try to log on to a server. To address this problem, we can edit the SSH Config file to add a nickname for the server. This way, SSH knows which server to log on to when you type the nickname.


To set up, take the following steps:
- Create or edit the `~/.ssh/config` file
- add the following lines in the file

```
Host ieng6
HostName ieng6.ucsd.edu
User cs15lsp22zzz (use your username)
```

- You may use the command `cat > ~/.ssh/config ` and paste in the lines above

When you are finished with the steps above, your config file should look like this:


![image](images/Lab3/SSH_Config.png)

After the config file has been set up, you should be able to type `ssh ieng6` and log in successfully

![image](images/Lab3/Ieng6_Login.png)

Now I will try to `scp` a file to the server with the nickname shortcut. I will execute the following command.
```
touch test.txt
scp test.txt ieng6:~/
```
- I created the file `test.txt`
- I copied the file to the ieng6 server
- After this, I should be able to see the file on the server when I SSH in.

![image](images/Lab3/SCP_ieng6.png)

----

<br/><br/>

## Github Access