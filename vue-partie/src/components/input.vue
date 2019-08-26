<template>
    <div class="input">
      <el-button @click="show">大按钮</el-button>
      <label>姓名</label>
      <input type="text" v-model="nom"></input>
      <label>Id</label>
      <input type="text" v-model="myid"></input>
      <input type="button" value="按钮2" @click="add"></input>
      <p v-for="item in list">{{item.nom}} --- {{item.myid}} --- {{item.time}}</p>
    </div>
</template>
<script type="text/javascript">
    export default {
        data() {
            return {
              nom:'french',
              myid:33,
              list:[
                {nom:'李白', myid: 22, time:new Date()},
                {nom:'杜甫', myid: 44, time:new Date()},
                {nom:'白居易', myid: 11, time:new Date()},
              ],

            }
        },
        created(){ //methods和生命周期函数都要和data同级。。别写进去了

          this.getList('http://localhost:8088/user/show')
        },
        methods:{
          show:function(){
            console.log('测试一下')
          },
          add:function(){

            this.list.push({
              nom : this.nom,
              myid: this.myid,
              time :new Date()
            })

            this.nom=''
            this.myid=''
          },
          getList:function(url){ //需要想办法导入vue-resource / jquery
              //在App.vue中导入并且Vue.use即可（前提是npm已下载)
            // this.$http.get(url).then(function(res){
            //   //通过$http获取到的数据，都在result.body中
            //   var dbdata=res.body
            //   //console.log()
            //   dbdata.forEach(element => {
            //     this.list.push({myid:element.id,  nom:element.name, time:new Date()})
            //   });
            //
            // })

            this.$http.get(url).then(res=>{
              var cur = res.body
              if(res.status===200){
                this.list = cur
              }else{
                alert('显示失败')
              }
            })

          }
        }
    }
</script>
