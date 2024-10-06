def call(boolean abortPipeline = false) {
    def branchName = env.BRANCH_NAME ?: 'no-branch' 

    echo "Iniciando análisis estático de código en la rama ${branchName}"
    
    timeout(time: 5, unit: 'MINUTES') {
        sh 'echo "Ejecución de las pruebas de calidad de código simulada"'
    }

    if (abortPipeline) {
        error("Abortando el pipeline según configuración.")
    }

    if (branchName == 'master') {
        error("Abortando el pipeline en la rama master.")
    } else if (branchName.startsWith('hotfix')) {
        error("Abortando el pipeline en la rama hotfix.")
    } else {
        echo "El pipeline continuará en la rama ${branchName}."
    }
}
