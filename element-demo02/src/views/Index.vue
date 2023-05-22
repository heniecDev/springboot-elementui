<template>
    <div class="app-container">
        <el-button
        size="mini"
        @click="handleAdd"
        >添加
        </el-button>
        <el-table
                :data="tableData"
                border
                style="width: 800px">

            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="图书名称"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="图书作者"
                    width="150">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="200">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.row)">编辑
                    </el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.row)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "Index",
        methods: {
            getList() {
                axios.get('http://localhost:8082/book/list').then((resp) => {
                    this.tableData = resp.data
                })
            },
            handleEdit(row) {
                this.$router.push('/update?id=' + row.id)
            },

            handleDelete(row) {
                const that = this
                that.$confirm('此操作将永久删除《' + row.name + '》, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // axios.delete('http://localhost:8082/book/delete/' + row.id).then(function (resp) {
                    //     if (resp.data) {
                    //         that.$alert('《' + row.name + '》删除成功', '提示', {
                    //             confirmButtonText: '确定',
                    //             callback: action => {
                    //                 location.reload()
                    //             }
                    //         });
                    //     }
                    // })
                    console.log(row.id)
                    axios.get('http://localhost:8082/book/delete/' + row.id).then((resp) => {
                        if (resp.data) {
                            that.$alert('《' + row.name + '》删除成功', '提示', {
                                confirmButtonText: '确定',

                                // callback: action => {
                                //     location.reload()
                                // }
                            });
                            this.getList()
                        }
                    })
                }).catch(() => {
                    that.$message({});
                });
            },
            handleAdd() {
                this.$router.push('/add')
            }
        },
        created() {
            // const that = this;
            // axios.get('http://localhost:8082/book/list').then(function (resp) {
            //     that.tableData = resp.data
            // });
            this.getList()
        },
        data() {
            return {
                tableData: []
            }
        }
    }
</script>

<style scoped>

</style>