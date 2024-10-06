def call(boolean abortPipeline = false) {
    echo "Iniciando análisis estático de código"
    
    // Timeout de 5 minutos para el análisis
    timeout(time: 5, unit: 'MINUTES') {
        withSonarQubeEnv('SonarQube') {
            sh 'echo "Ejecución de las pruebas de calidad de código simulada"'
        }
    }

    // Si el parámetro abortPipeline es true, abortar el pipeline
    if (abortPipeline) {
        error("Abortando el pipeline según configuración.")
    }
}
