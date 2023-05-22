<template>
    <div style="width: 300px">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px" >
            <el-form-item label="编号" prop="age" >
                <el-input v-model="form.id" ></el-input>
            </el-form-item>
            <el-form-item label="图书名称" prop="bookname">
                <el-input v-model="form.name" ></el-input>
            </el-form-item>
            <el-form-item label="图书作者" prop="bookauthor">
                <el-input v-model="form.author"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('form')">立即添加</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Add",
        data() {
            return {
                form: {
                    id: '',
                    name: '',
                    author: ''
                },
                rules: {
                    // name:[
                    //     { require: true,message:'请输入图书名称',trigger:'blur' },
                    //     { min:2, max:20,message:'长度在 2 到 20 个字符',trigger:'blur'}
                    // ]
                }
            }
        },
        methods:{
            onSubmit(formName){
                // this.$refs[formName].validate((valid)=>{
                //     if(valid){
                console.log(this.form)
                axios.post('http://localhost:8082/book/add', this.form).then((resp) => {
                    console.log(resp.data)
                    if (resp.data) {
                        alert('submit');
                        // that.$router.push('/index')
                    }else {
                        alert('error submit!!');
                    }
                })
                //     }else{
                //         console.log('error submit!!');
                //         return false;
                //     }
                // });
            }
        }
    }
</script>

<style scoped>

</style>