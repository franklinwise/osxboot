#!/bin/bash

if [ "$(uname -s)" != "Darwin" ]; then
  exit 0
fi

#several things require xcode to be installed and the xcode terminal tools to be installed

#install xcode command line tools, this will also install git
xcode-select --install

sudo easy_install pip
sudo CFLAGS=-Qunused-arguments CPPFLAGS=-Qunused-arguments pip install ansible --quiet
#sudo pip install --upgrade bumpversion

#ensure brew is installed
if [ command -v brew >/dev/null 2>&1 ]; then
	echo "Brew not installed. Installing Brew..." 
	ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
	
	brew doctor

	# so that brew install does not require root privledge
	sudo chown -R $USER /usr/local/*
fi

echo "Updating Homebrew packages..."
brew update

# to install apps like chrome that aren't development packages
# https://github.com/caskroom/homebrew-cask
brew install caskroom/cask/brew-cask

brew install gpg
gpg --keyserver hkp://keys.gnupg.net --recv-keys D39DC0E3

brew install wget
brew install tree
brew cask install p4merge

# needed for version control info on the shell
brew install vcprompt

brew cask install vagrant
brew cask install virtualbox
brew install boot2docker

# a better terminal
brew cask install iterm2

# IRC client
brew cask install limechat

# macvim
brew install macvim --with-cscope --with-lua --override-system-vim

# source control, other than git, sometime go lang will use this
brew install mercurial



