String template = new File("${project.basedir}/src/main/resources/docker/DockerComposeTemplate".toString()).getText()

def dockerFileText = new groovy.text.SimpleTemplateEngine().createTemplate(template)
        .make([tag: project.version])

println "writing dir " + "${project.basedir}/src/main/resources/scripts/docker-compose/docker-compose.yml"

println "writing file"
File dockerFile = new File("${project.basedir}/src/main/resources/scripts/docker-compose/docker-compose.yml".toString())

dockerFile.withWriter('UTF-8') { writer ->
    writer.write(dockerFileText)
}