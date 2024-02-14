const perguntas = [
  {
    pergunta: "Qual destas é uma maneira correta de declarar uma variável em JavaScript?",
    respostas: [
      "var myVar;",
      "let myVar;",
      "const myVar;"
    ],
    correta: 1
  },
  {
    pergunta: "Qual operador é utilizado para atribuição de valores em JavaScript?",
    respostas: [
      " ==",
      " =",
      " ==="
    ],
    correta: 1
  },
  {
    pergunta: "Qual função é usada para imprimir algo no console em JavaScript?",
    respostas: [
      "print()",
      "log()",
      "console()"
    ],
    correta: 1
  },
  {
    pergunta: "Como se verifica se uma variável é do tipo 'number' em JavaScript?",
    respostas: [
      "typeof myVar === 'number'",
      "myVar.type === 'number'",
      "isNumber(myVar)"
    ],
    correta: 0
  },
  {
    pergunta: "Qual é a saída da expressão '2' + 2 em JavaScript?",
    respostas: [
      "'4'",
      "4",
      "'22'"
    ],
    correta: 2
  },
  {
    pergunta: "Qual é o resultado da expressão 3 + 2 + '5' em JavaScript?",
    respostas: [
      "10",
      "'55'",
      "'35'"
    ],
    correta: 2
  },
  {
    pergunta: "Qual é o método utilizado para converter uma string em um número inteiro em JavaScript?",
    respostas: [
      "parseInt()",
      "toInt()",
      "number()"
    ],
    correta: 0
  },
  {
    pergunta: "Qual é a palavra-chave usada para definir uma função em JavaScript?",
    respostas: [
      "func",
      "function",
      "def"
    ],
    correta: 1
  },
  {
    pergunta: "Qual é o resultado da expressão 10 % 3 em JavaScript?",
    respostas: [
      "0",
      "1",
      "2"
    ],
    correta: 2
  },
  {
    pergunta: "Qual é o método utilizado para adicionar um elemento ao final de um array em JavaScript?",
    respostas: [
      "append()",
      "push()",
      "add()"
    ],
    correta: 1
  }
];

const quiz = document.querySelector('#quiz')
const template = document.querySelector ('template')

const corretas = new Set()
const totalDePerguntas = perguntas.length
const mostrarTotal = document.querySelector('#acertos span')
mostrarTotal.textContent = corretas.size + ' de ' + totalDePerguntas 

// loop ou laço de repeticao
//pergunta
for(const item of perguntas) {
const quizItem = template.content.cloneNode(true)
quizItem.querySelector('h3').textContent = item.pergunta

//resposta pos pra funcionar a parte da bolinha
for(let resposta of item.respostas) {
  const dt = quizItem.querySelector('dl dt').cloneNode(true)
  dt.querySelector('span').textContent = resposta
  dt.querySelector('input').setAttribute('name', 'pergunta-' + perguntas.indexOf(item))
  dt.querySelector('input').value = item.respostas.indexOf(resposta)
  dt.querySelector('input').onchange = (event) => {
    const estaCorreta =event.target.value == item.correta
    
    corretas.delete(item)
    if(estaCorreta) {
      corretas.add(item)
    }

   mostrarTotal.textContent = corretas.size + ' de ' + totalDePerguntas 

  }



  quizItem.querySelector('dl').appendChild(dt)
  

}

//remove a resposta do template "resposta 1"
quizItem.querySelector('dl dt').remove()


//coloca a pertunta na tela
quiz.appendChild(quizItem)
}
