DeadLock está diretamente relacionado ao utilizar uma recurso que tem mútua concorrência e interdependia entre os Processos envolvidos. 
Onde Cada Processo fica impossibilitado de executar suas funções esperando a liberação dos  recursos alocados por outro processo, 
que também se encontra neste Impasse. 

De maneira simplificada para acontecer um DeadLock precisa ter quatro Características. 

- Processos (Threads) concorrentes / Programação em Paralela; 

- Concorrências de recursos sejam de Hardware / Software não preemptivos; 

- dependência mútua; 

- Operações atômicas, quando determinado recurso fica alocado a ao processo que não pode compartilhar com outro processo. 



Entre algumas solução para enfrentar este Impasse, e a consultado sincronizada dos recursos, vários algoritmos tanto de programação (Semáforo) utilização esta questão de serialização do com recursos 
para diminuir o risco que aconteça o DeadLock. 
Uma vez que o DeadLockl acontece não tem muita coisa fazer, por este motivos a maioria das soluções com um finalidade prevenir e/ ou diminuir o risco para que o DeadLock aconteça.
