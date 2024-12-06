
document.addEventListener("DOMContentLoaded", () => {
    createMatrixInputs("matrixA");
    createMatrixInputs("matrixB");
});

function createMatrixInputs(matrixId) {
    const container = document.getElementById(matrixId);
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            const input = document.createElement("input");
            input.type = "number";
            input.id = `${matrixId}-${i}-${j}`;
            container.appendChild(input);
        }
    }
}

async function operate(operation) {
    const matrixA = getMatrixValues("matrixA");
    const matrixB = getMatrixValues("matrixB");
    const scalar = document.getElementById("scalar").value ? parseInt(document.getElementById("scalar").value) : null;

    const url = `http://localhost:8080/${operation}`;
    let method = "POST";
    let body = JSON.stringify({
        matrizA: matrixA,
        matrizB: matrixB
    });

    if (operation === 'escalar') {
        // Escalar operation requires the scalar factor in the request
        body = JSON.stringify({ matrizA: matrixA });
        method = 'POST';
        const params = new URLSearchParams();
        params.append('escalar', scalar);
        fetch(url + '?' + params.toString(), {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: body
        })
            .then(response => response.json())
            .then(data => displayResult(data))
            .catch(err => console.log("Error: ", err));
    }

    if (operation === 'simetrica') {
        fetch(url + '/', {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: body
        })
            .then(response => response.json())
            .then(data => displayResult(data))
            .catch(err => console.log("Error: ", err));
    }
    else {
        fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: body
        })
            .then(response => response.json())
            .then(data => displayResult(data))
            .catch(err => console.log("Error: ", err));
    }
}

function getMatrixValues(matrixId) {
    const matrix = [];
    for (let i = 0; i < 5; i++) {
        const row = [];
        for (let j = 0; j < 5; j++) {
            const value = parseInt(document.getElementById(`${matrixId}-${i}-${j}`).value);
            row.push(value);
        }
        matrix.push(row);
    }
    return matrix;
}

function displayResult(result) {
    const resultDiv = document.getElementById("result");
    resultDiv.innerHTML = ""; // Limpiar resultados previos

    if (Array.isArray(result)) {
        const title = document.createElement("h3");
        title.innerText = "Resultado de la Operación:";
        resultDiv.appendChild(title);

        const table = document.createElement("table");
        result.forEach(row => {
            const tr = document.createElement("tr");
            row.forEach(cell => {
                const td = document.createElement("td");
                td.innerText = cell; // Mostrar el valor de la celda
                tr.appendChild(td);
            });
            table.appendChild(tr);
        });
        resultDiv.appendChild(table); // Añadir la tabla al div de resultados
    } else if (typeof result === "boolean") {
        resultDiv.innerHTML = result
            ? "La matriz es simétrica."
            : "La matriz no es simétrica.";
    } else {
        resultDiv.innerHTML = "Operación completada.";
    }
}