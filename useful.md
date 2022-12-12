```bash

16962@JJia MINGW64 ~/OneDrive/桌面 (master)
$ cd existing_git_repo
bash: cd: existing_git_repo: No such file or directory

16962@JJia MINGW64 ~/OneDrive/桌面 (master)
$ git remote add origin https://gitee.com/li17161874988/software-practice-ii.git
error: remote origin already exists.

16962@JJia MINGW64 ~/OneDrive/桌面 (master)
$ git push -u origin "master"
error: src refspec master does not match any
error: failed to push some refs to 'https://gitee.com/li17161874988/software-practice-ii.git'

16962@JJia MINGW64 ~/OneDrive/桌面 (master)
$ git remote add origin https://gitee.com/li17161874988/software-practice-ii.git
error: remote origin already exists.

16962@JJia MINGW64 ~/OneDrive/桌面 (master)
$ mkdir spark

16962@JJia MINGW64 ~/OneDrive/桌面 (master)
$ cd spark

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git init
Initialized empty Git repository in C:/Users/16962/OneDrive/桌面/spark/.git/

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ touch readme.txt

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git add readme.txt

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git commit -m "first commit"
[master (root-commit) 91e0a82] first commit
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 readme.txt

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git remote add origin https://gitee.com/li17161874988/software-practice-ii.git

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git push -u orgin  master
fatal: 'orgin' does not appear to be a git repository
fatal: Could not read from remote repository.

Please make sure you have the correct access rights
and the repository exists.

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git push -u origin  master
To https://gitee.com/li17161874988/software-practice-ii.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://gitee.com/li17161874988/software-practice-ii.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git pull --rebase origin master
remote: Enumerating objects: 6, done.
remote: Counting objects: 100% (6/6), done.
remote: Compressing objects: 100% (4/4), done.
remote: Total 6 (delta 0), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (6/6), 703 bytes | 46.00 KiB/s, done.
From https://gitee.com/li17161874988/software-practice-ii
 * branch            master     -> FETCH_HEAD
 * [new branch]      master     -> origin/master
Successfully rebased and updated refs/heads/master.

16962@JJia MINGW64 ~/OneDrive/桌面/spark (master)
$ git push origin master
Enumerating objects: 3, done.
Counting objects: 100% (3/3), done.
Delta compression using up to 4 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (2/2), 238 bytes | 238.00 KiB/s, done.
Total 2 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Powered by GITEE.COM [GNK-6.4]
To https://gitee.com/li17161874988/software-practice-ii.git
   f9bf519..6cfdbe9  master -> master


```

