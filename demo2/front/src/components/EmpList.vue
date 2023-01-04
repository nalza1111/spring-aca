<template>
    <table>
        <thead>
            <tr>
                <th>사원번호</th>
                <th>이름</th>
                <th>성</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="emp in empList" :key="emp.employeeId">
                <td v-text="emp.employeeId"/>
                <td v-text="emp.firstName"/>
                <td v-text="emp.lastName"/>
            </tr>
        </tbody>
    </table>
</template>
<script>

export default{
    name: 'EmpList',
    data: function(){
        return{
            empList: {}
        }
    },
    created: function(){
        fetch('http://localhost:85/empInfoList')
          .then(response => response.json())
          .then(data =>{
                this.empList = data;
          })
          .catch(error => console.log(error));
    }
}
</script>
