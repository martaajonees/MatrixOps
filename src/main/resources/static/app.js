
document.addEventListener("DOMContentLoaded", () => {
    createMatrixInputs("matrixA", 5);
    createMatrixInputs("matrixB", 5);

});

const matrixDimensions = {
    matrixA: 5, 
    matrixB: 5, 
};

function createMatrixInputs(matrixId, size) {
    const container = document.getElementById(matrixId);
    container.innerHTML = ""; // Limpiar inputs previos

    for (let i = 0; i < size; i++) {
        const row = document.createElement("div");
        row.className = "matrix-row";
        for (let j = 0; j < size; j++) {
            const input = document.createElement("input");
            input.type = "number";
            input.id = `${matrixId}-${i}-${j}`;
            input.value = 0;
            container.appendChild(input);
        }
        container.appendChild(row);
    }
}

function adjustMatrix(matrixId, adjustment) {
    const size = matrixDimensions[matrixId] + adjustment;

    if (size < 1) {
        alert("La matriz debe tener al menos una fila y una columna.");
        return;
    }

    matrixDimensions[matrixId] = size;
    createMatrixInputs(matrixId, size);
} 

async function operate(operation) {
    const matrixA = getMatrixValues("matrixA");
    const matrixB = getMatrixValues("matrixB");
    const scalar = document.getElementById("scalar")?.value ? parseInt(document.getElementById("scalar").value) : null;

    const url = `https://matrixops.onrender.com/${operation}`;
    let method = "POST";
    let body = JSON.stringify({
        matrizA: matrixA,
        matrizB: matrixB
    });

    try {
        let response;
        if (operation === 'escalar') {
            body = JSON.stringify({ matrizA: matrixA });
            const params = new URLSearchParams();
            params.append('escalar', scalar);

            response = await fetch(url + '?' + params.toString(), {
                method,
                headers: { 'Content-Type': 'application/json' },
                body
            });
        } else if (operation === 'simetrica' || operation === 'transpuesta' || operation === 'diagonal') {
            console.log("Matriz A:", matrixA);
            body = JSON.stringify({ matrizA: matrixA });
            response = await fetch(url, {
                method,
                headers: { 'Content-Type': 'application/json' },
                body
            });
        } else {
            response = await fetch(url, {
                method,
                headers: { 'Content-Type': 'application/json' },
                body
            });
        }

        if (response.ok) {
            const data = await response.json();
            displayResult(data);
        } else {
            const errorData = await response.json();
            displayResult(errorData);
        }
        
    } catch (error) {
        console.error("Error: ", error);
    }
}

function getMatrixValues(matrixId) {
    const size = matrixDimensions[matrixId];
    const matrix = [];
    for (let i = 0; i < size; i++) {
        const row = [];
        for (let j = 0; j < size; j++) {
            const value = parseInt(document.getElementById(`${matrixId}-${i}-${j}`).value) || 0;
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
    } else if (result.error) {
        resultDiv.innerHTML = "Error: " + result.error;
    } else {
        resultDiv.innerHTML = "Operación completada.";
    }
}
