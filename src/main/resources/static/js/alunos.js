const tabelaAlunos = document.querySelector("#tabelaAlunos")

async function getAlunos() {
    try {
        const alunos = await Api.getAlunos();
        const lista = alunos.content ?? [];

        let tabHtml =
            `<thead>
                <th scope="col">Nome</th>
                <th scope="col">Plano Escolhido</th>
                <th scope="col">Status</th>
                <th scope="col">Vencimento</th>
                <th scope="col">Ações</th>
            </thead>
            <tbody>`
            ;

        for (const aluno of lista) {
            tabHtml += `
                <tr>
                    <td>
                    <a href="aluno.html?id=${aluno.id}" style="cursor:pointer">
                    ${aluno.nome ?? ""}
                    </a>
                    </td>
                    <td>${aluno.planoNome ?? "Nenhum"}</td>
                    <td>${aluno.status ?? ""}</td>
                    <td>${formatarData(aluno.diaVencimento) ?? ""}</td>
                    <td><button onclick="deletarAluno('${aluno.id}')">Excluir</button></td>
                </tr>
            `;
        }

        tabHtml += `</tbody>`;
        tabelaAlunos.innerHTML = tabHtml;
    } catch (error) {
        alert(error?.message || "Erro ao carregar alunos");
    }
}
async function deletarAluno(id) {
    if (!confirm("Ao excluir um aluno, você também estará excluindo todos seus pagamentos.\nVocê tem certeza que deseja excluir o aluno?")) return;
    try {
        await Api.deletarAluno(id);
        alert("Aluno excluído com sucesso!");
        getAlunos();
    } catch (error) {
        alert(error?.message || "Erro ao excluir aluno");
    }
}
getAlunos();