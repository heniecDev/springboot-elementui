<template>
    <div>
        <i class="el-icon-star-off"></i>
        <i class="el-icon-share"></i>
        <i class="el-icon-delete"></i>
        <el-row>
        <el-button>默认按钮</el-button>
        <el-button type="primary">主要按钮</el-button>
        <el-button type="success">成功按钮</el-button>
        <el-button type="info">信息按钮</el-button>
        <el-button type="warning">警告按钮</el-button>
        <el-button type="danger">危险按钮</el-button>
        </el-row>
        <el-row>
        <el-radio v-model="radio" label="1">选项一</el-radio>
        <el-radio v-model="radio" label="2">选项二</el-radio>
        </el-row>
    </div>

</template>

<script>
    export default {
        name: "Test",
        methods:{
            test(){
                this.loading = true
                setTimeout(()=>{
                    this.loading = false
                },3000)
            }
        },
        data(){
            return{
                underline : true,
                loading:false,
                radio :"1"
            }

        }
    }
</script>

<style scoped>

</style>