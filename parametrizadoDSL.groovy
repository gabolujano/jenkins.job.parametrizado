job('ejemplo-job-DSL-github') {
  description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/gabolujano/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('gabolujano')
      node / gitConfigEmail('lujano@gmail.com')
    }
  }
   parameters {
    stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  triggers {
    cron('H/7 * * * *')
  }
  steps {
     shell("bash jobscript.sh")
  }
 }
