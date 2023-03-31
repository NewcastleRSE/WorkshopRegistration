PROJECTNAME=`basename ${PWD}`

serve:
	docker run -d --rm --name $(PROJECTNAME) -p 80:80 jannetta/registration:0.1

stop:
	docker stop $(PROJECTNAME)

make build:
	docker build -t $(PROJECTNAME) -t jannetta/registration:0.1 .
