# VS-code
codes-learning

# 将当前目录下的项目推送到指定 GitHub 仓库的完整指令步骤 

1.确保本地已安装 Git，且当前目录是项目根目录；

2.若仓库是首次关联，需先初始化（已初始化可跳过步骤 1）；

3.若仓库已有远程关联，可先执行 git remote -v 查看，若需替换远程地址，用 git remote set-url origin https://github.com/zhuoer-GG/VS-code.git 覆盖。

## 1. 初始化本地仓库（首次推送时执行，已初始化则跳过）
git init

## 2. 将当前目录所有文件添加到暂存区
git add .

## 3. 提交暂存区文件到本地仓库（备注信息可自定义）
git commit -m "初始化项目/更新项目内容"

## 4. 关联远程GitHub仓库（首次关联执行，已关联则跳过）
git remote add origin https://github.com/zhuoer-GG/VS-code.git

## 5. 拉取远程仓库最新内容（避免冲突，若远程为空可跳过）
git pull origin main --allow-unrelated-histories

## 6. 推送本地代码到远程仓库的main分支（默认主分支为main，若为master则替换）
git push -u origin main